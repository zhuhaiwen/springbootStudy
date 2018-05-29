package com.founder.invoice;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author zhuhw
 * @date 2018/5/28 18:44
 */
@FeignClient(name = "invoice", url = "${invoice.server}")
public interface IInvoiceClient {

    @RequestMapping(value = "/invoice/testFeign", method = RequestMethod.GET)
    Map<String, Object> testFeign(@RequestParam("id") Integer id);
}
