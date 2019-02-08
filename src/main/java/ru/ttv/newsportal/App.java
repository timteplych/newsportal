package ru.ttv.newsportal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.ttv.newsportal.dao.AdvCategoryDAO;
import ru.ttv.newsportal.dao.AdvDAO;
import ru.ttv.newsportal.model.Adv;
import ru.ttv.newsportal.model.AdvCategory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
        AdvDAO advDAO = ctx.getBean(AdvDAO.class);
        AdvCategoryDAO advCategoryDAO = ctx.getBean(AdvCategoryDAO.class);

        AdvCategory advCategory = new AdvCategory();
        advCategory.setTitle("Pets");
        advCategoryDAO.persist(advCategory);

        Adv adv = new Adv();
        adv.setCategory(advCategory);
        adv.setTitle("Кот Том");
        adv.setPhone("8902478562");
        advDAO.persist(adv);
    }
}
