package edu.sber.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class TextService {

    public boolean checkText(String text){
        if(text.isBlank()){
            return true;
        }
        Pattern pattern = Pattern.compile("\\([^()]*\\)");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String bracketPair = matcher.group();
            String contentBetweenBrackets = bracketPair.substring(1, bracketPair.length() - 1);

            if (contentBetweenBrackets.trim().isEmpty()) {
                return false;
            }
        }

        return true;
    }

}
