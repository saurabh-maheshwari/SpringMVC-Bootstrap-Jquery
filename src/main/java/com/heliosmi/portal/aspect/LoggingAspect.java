/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.heliosmi.portal.aspect;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.exception.ExceptionUtils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Aspect to cut across all locally defined beans.
 * 
 * 
 * @author Saurabh Maheshwari
 */
@Component
@Aspect
public class LoggingAspect {
	Logger log = LoggerFactory.getLogger("Profiler");

	@Pointcut("within(com.heliosmi.example..*)")
	public void allBeans() {
	}

	@Around("allBeans()")
	public Object profiler(ProceedingJoinPoint pjp) throws Throwable {

		long start = System.nanoTime();
		String classMethodName = pjp.getTarget().getClass().getSimpleName() + "." + pjp.getSignature().getName();
		log.info(classMethodName + " - called with param(s) " + ToStringBuilder.reflectionToString(pjp.getArgs()));

		Object returnValue = null;
		try {
			returnValue = pjp.proceed();
		} catch (Exception exception) {
			log.error(ToStringBuilder.reflectionToString(ExceptionUtils.getRootCause(exception)));
			log.error(ExceptionUtils.getStackTrace(exception));
			throw exception;
		}

		long end = System.nanoTime();
		log.info(classMethodName + " - finished. Took " + (end - start) + " milliseconds. ");

		return returnValue;
	}

}
