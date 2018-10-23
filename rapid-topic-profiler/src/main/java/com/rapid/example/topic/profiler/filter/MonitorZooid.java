/// **
// *
// */
// package com.rapid.example.topic.profiler.filter;
//
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Pointcut;
// import org.aspectj.lang.reflect.MethodSignature;
//
// import lombok.extern.slf4j.Slf4j;
//
/// **
// * @author yueny09 <yueny09@163.com>
// *
// * @DATE 2017年11月2日 下午12:08:23
// *
// */
// @Slf4j
// @Aspect
// public class MonitorZooid {
// // 一秒
// private static final long ONE_SECOND = 10;
//
// public final String POINT;
//
// // public MonitorZooid() {
// // this("execution (* com.rapid.example.topic.profiler.task.*.*(..))");
// // }
//
// public MonitorZooid(final String point) {
// POINT = point;
// }
//
// /**
// * 打印方法执行耗时的信息，如果超过了一定的时间，才打印
// *
// * @param methodName
// * 方法名称
// * @param startTime
// * 开始时间
// * @param endTime
// * 结束时间
// */
// private void printExecTime(final String methodName, final long startTime,
/// final long endTime) {
// final long diffTime = endTime - startTime;
// if (diffTime > ONE_SECOND) {
// log.warn("-----" + methodName + " 方法执行耗时：" + diffTime + " ms");
// }
// }
//
// /**
// * 切入点
// */
// @Pointcut(POINT)
// public void profilerPointCut() {
// // .
// }
//
// /**
// * 统计方法执行耗时Around环绕通知
// *
// * @param joinPoint
// * @return
// */
// @Around("profilerPointCut()")
// public Object timeAround(final ProceedingJoinPoint joinPoint) throws
/// Throwable {
// // 定义返回对象、得到方法需要的参数
// Object obj = null;
// final Object[] args = joinPoint.getArgs();
// final long startTime = System.currentTimeMillis();
//
// try {
// obj = joinPoint.proceed(args);
// } catch (final Throwable e) {
// log.error("统计某方法执行耗时环绕通知出错", e);
// throw e;
// }
//
// // 获取执行的方法名
// final long endTime = System.currentTimeMillis();
// final MethodSignature signature = (MethodSignature) joinPoint.getSignature();
// final String methodName = signature.getDeclaringTypeName() + "." +
/// signature.getName();
//
// // 打印耗时的信息
// this.printExecTime(methodName, startTime, endTime);
//
// return obj;
// }
//
// }
