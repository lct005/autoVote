package scenarios.admin.form;

import core.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class FormTest extends BaseTest {

    @Test
    public void testCreateForm(){
        open("http://sapotacorp.vn/");
        System.out.println("DONE");
    }

    @Test
    public void testEditForm(){
        open("http://sapotacorp.vn/");
        System.out.println("DONE");
    }
}
