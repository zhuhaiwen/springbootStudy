package com.founder.controller.temp;

import com.founder.invoice.IInvoiceClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zhuhw
 * @date 2018/5/28 18:51
 */
@RestController
@RequestMapping(value = "${drap.api.base-path:/api}/invoice", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(description = "发票接口")
public class InvoiceApi {

    private Logger logger = LoggerFactory.getLogger(InvoiceApi.class);

    @Autowired
    private IInvoiceClient invoiceClient;

    @ApiOperation(value = "请求发票列表" ,notes = "请求发票列表")
    @RequestMapping(value = "/testInvoice", method = RequestMethod.GET)
    public Map<String, Object> testInvoice(@ApiParam(value = "测试id", required = true) @RequestParam("id") Integer id) {
        logger.info(id.toString());
        return invoiceClient.testFeign(id);
    }
}
