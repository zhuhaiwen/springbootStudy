package com.founder.entity.log;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author zhwen
 * @version 1.0
 * @company 北大方正电子
 * @date 2017-11-11 16:38
 **/
@Entity
@Table(name = "t_logger_infos")
public class TLoggerInfosEntity {
    private int id;
    private String clientIp;
    private String uri;
    private String type;
    private String method;
    private String paramData;
    private String sessionId;
    private Timestamp time;
    private String returnTime;
    private String returnData;
    private String httpStatusCode;
    private Integer timeConsuming;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "client_ip")
    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    @Basic
    @Column(name = "uri")
    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "method")
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Basic
    @Column(name = "param_data")
    public String getParamData() {
        return paramData;
    }

    public void setParamData(String paramData) {
        this.paramData = paramData;
    }

    @Basic
    @Column(name = "session_id")
    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Basic
    @Column(name = "time")
    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    @Basic
    @Column(name = "return_time")
    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    @Basic
    @Column(name = "return_data")
    public String getReturnData() {
        return returnData;
    }

    public void setReturnData(String returnData) {
        this.returnData = returnData;
    }

    @Basic
    @Column(name = "http_status_code")
    public String getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(String httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    @Basic
    @Column(name = "time_consuming")
    public Integer getTimeConsuming() {
        return timeConsuming;
    }

    public void setTimeConsuming(Integer timeConsuming) {
        this.timeConsuming = timeConsuming;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TLoggerInfosEntity that = (TLoggerInfosEntity) o;

        if (id != that.id) return false;
        if (clientIp != null ? !clientIp.equals(that.clientIp) : that.clientIp != null) return false;
        if (uri != null ? !uri.equals(that.uri) : that.uri != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (method != null ? !method.equals(that.method) : that.method != null) return false;
        if (paramData != null ? !paramData.equals(that.paramData) : that.paramData != null) return false;
        if (sessionId != null ? !sessionId.equals(that.sessionId) : that.sessionId != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (returnTime != null ? !returnTime.equals(that.returnTime) : that.returnTime != null) return false;
        if (returnData != null ? !returnData.equals(that.returnData) : that.returnData != null) return false;
        if (httpStatusCode != null ? !httpStatusCode.equals(that.httpStatusCode) : that.httpStatusCode != null)
            return false;
        if (timeConsuming != null ? !timeConsuming.equals(that.timeConsuming) : that.timeConsuming != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (clientIp != null ? clientIp.hashCode() : 0);
        result = 31 * result + (uri != null ? uri.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (method != null ? method.hashCode() : 0);
        result = 31 * result + (paramData != null ? paramData.hashCode() : 0);
        result = 31 * result + (sessionId != null ? sessionId.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (returnTime != null ? returnTime.hashCode() : 0);
        result = 31 * result + (returnData != null ? returnData.hashCode() : 0);
        result = 31 * result + (httpStatusCode != null ? httpStatusCode.hashCode() : 0);
        result = 31 * result + (timeConsuming != null ? timeConsuming.hashCode() : 0);
        return result;
    }
}
