package result;

import lombok.Data;

import java.io.Serializable;
@Data
public class Result<T> implements Serializable{
    private Integer code;
    private String msg;
    private T data;
    public static <T> Result<T> sucess(){
        Result<T>result=new Result<>();
        result.code=1;
        result.msg="响应成功";
        return result;
    }
    public static <T> Result<T> sucess(T object){
        Result<T>result=new Result<>();
        result.code=1;
        result.msg="响应成功";
        result.data=object;
        return result;
    }
    public static <T> Result<T> error(){
        Result<T>result=new Result<>();
        result.code=0;
        result.msg="响应失败";
        return result;
    }
    public static <T> Result<T> error(String msg){
        Result<T>result=new Result<>();
        result.code=0;
        result.msg=msg;
        return result;
    }
}