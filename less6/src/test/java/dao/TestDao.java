package dao;


import com.tsystems.dao.PlaceDao;
import com.tsystems.dao.UserDao;
import com.tsystems.model.Place;
import com.tsystems.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;


@ContextConfiguration(locations = "classpath*:app.xml" )
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class TestDao {

    @Autowired
    UserDao userDao;

    @Autowired
    PlaceDao placeDao;

    @Test
    public void test(){
        User user=new User("Ivan",111);
        Place magazine =new Place("Mega-Dybenko");
        userDao.saveUser(user);
        placeDao.savePlace(magazine);
    }

}

