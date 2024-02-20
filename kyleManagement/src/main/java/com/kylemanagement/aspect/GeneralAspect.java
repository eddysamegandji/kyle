package com.kylemanagement.aspect;

import com.kylemanagement.model.User;
import com.kylemanagement.model.UserLog;
import com.kylemanagement.repository.UserLogRepository;
import com.kylemanagement.repository.UserRepository;
import java.time.Instant;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class GeneralAspect {

  final UserLogRepository userLogRepository;
  final UserRepository userRepository;

  @Pointcut("execution(* com.kylemanagement.controller.*.*(..))")
  public void loggingPointCut() {}

  @Around("loggingPointCut()")
  public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    UserLog userLog = new UserLog();

    //        userLog.setUser((User)
    // SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    Optional<User> user = userRepository.findById(1l);
    if (user.isPresent()) {
      userLog.setUser(user.get());
    } else {
      log.error("User not exists");
      userLog.setUser(null);
    }
    userLog.setDate(Instant.now());
    userLog.setServiceName(proceedingJoinPoint.getSignature().toString());
    final Pattern pattern = Pattern.compile("password.*", Pattern.MULTILINE);
    final Object[] args = proceedingJoinPoint.getArgs();
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < args.length; i++) {
      result.append(args[i]);
      if (i < args.length - 1) {
        result.append(", ");
      }
    }
    final Matcher matcher = pattern.matcher(result);
    while (matcher.find()) {
      result =
          new StringBuilder(
              result.toString().replace(matcher.group(0), "").replaceAll("\n[ \t]*\n", "\n"));
    }

    userLog.setParams(result.toString());
    Object object = proceedingJoinPoint.proceed();

    if (object instanceof ResponseEntity<?> res) {
      userLog.setLogMessage(res.getStatusCode().toString());
      log.info(userLog.getServiceName() + " " + userLog.getParams()+ " "+ userLog.getLogMessage());
    }

    userLogRepository.save(userLog);
    return object;
  }
}
