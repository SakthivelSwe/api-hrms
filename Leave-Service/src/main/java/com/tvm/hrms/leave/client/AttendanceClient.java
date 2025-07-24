package com.tvm.hrms.leave.client;



import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "attendance-service")
public interface AttendanceClient
{

}
