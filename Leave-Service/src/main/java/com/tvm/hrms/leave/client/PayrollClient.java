package com.tvm.hrms.leave.client;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "payroll-service")
public interface PayrollClient
{

}