package edu.sber;

import edu.sber.service.TextService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SberCodeApplicationTests {

    @Autowired
    private TextService textService;

    @Test
    public void testBase() {
        String baseText = "Вчера я отправился в поход в лес (это мое любимое место для отдыха) вместе с друзьями." +
                " Мы выбрали маршрут, который проходил через горные потоки и поля (для разнообразия). В начале пути погода была отличной," +
                " солнце светило ярко, и птицы радостно пели. Однако, когда мы подошли ближе к вершине горы, небо стало покрываться облаками," +
                " (как будто природа готовила нам небольшой сюрприз). Несмотря на это, виды были захватывающими, особенно когда мы достигли высшей точки" +
                " и увидели прекрасный вид на долину (я почувствовал, что все усилия стоили того).";
        boolean result = textService.checkText(baseText);
        assertTrue(result);
    }


    @Test
    public void testValidBracketsWithWords() {
        String validText = "Пример (текста) с (правильными скобками).";
        boolean result = textService.checkText(validText);
        assertTrue(result);
    }

    @Test
    public void testEmptyBrackets() {
        String emptyBrackets = "Пример () с пустыми скобками.";
        boolean result = textService.checkText(emptyBrackets);
        assertFalse(result);
    }

    @Test
    public void testWithoutBrackets(){
        String withoutBrackets = "Пример без скобок";
        boolean result = textService.checkText(withoutBrackets);
        assertTrue(result);
    }

    @Test
    public void testEmptyText(){
        String emptyText = "";
        boolean result = textService.checkText(emptyText);
        assertTrue(result);
    }

    @Test
    public void testWithRecursiveBrackets(){
        String text = "((()))";
        boolean result = textService.checkText(text);
        assertFalse(result);
    }

}
