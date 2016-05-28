import com.basic.util.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by dell-pc on 2016/5/25.
 */
public class FileUtilsTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testListDircetory() throws Exception {
        FileUtils.listDircetory(new File("/"));
    }
}
