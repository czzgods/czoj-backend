package com.cz.czoj.judge.codesandbox;

import com.cz.czoj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.cz.czoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.cz.czoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.cz.czoj.model.enums.QuestionSubmitLanguageEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CodeSandboxTest {

    @Test
    void executeCode(){
        CodeSandbox codeSandbox = new ExampleCodeSandbox();
        String code = "int main() {}";
        String language = QuestionSubmitLanguageEnum.JAVA.getValue();
        List<String> inputList = Arrays.asList("1 2","3 4");
        ExecuteCodeRequest codeRequest = ExecuteCodeRequest
                .builder()
                .code(code)
                .language(language)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(codeRequest);
        Assertions.assertNotNull(executeCodeResponse);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String type = scanner.next();
            CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
            String code = "int main() {}";
            String language = QuestionSubmitLanguageEnum.JAVA.getValue();
            List<String> inputList = Arrays.asList("1 2","3 4");
            ExecuteCodeRequest codeRequest = ExecuteCodeRequest
                    .builder()
                    .code(code)
                    .language(language)
                    .inputList(inputList)
                    .build();
            ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(codeRequest);
        }
    }
}