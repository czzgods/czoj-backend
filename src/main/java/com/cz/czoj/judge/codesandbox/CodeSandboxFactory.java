package com.cz.czoj.judge.codesandbox;

import com.cz.czoj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.cz.czoj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.cz.czoj.judge.codesandbox.impl.ThirdPartyCodeSandbox;

import java.util.Scanner;

/**
 * 代码沙箱工厂（根据字符串参数创建指定的代码沙箱实例）
 */
public class CodeSandboxFactory {

    /**
     * 创建代码沙箱实例
     *
     * @param type 沙箱类型
     * @return
     */
    public static CodeSandbox newInstance(String type){
        switch (type){
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
