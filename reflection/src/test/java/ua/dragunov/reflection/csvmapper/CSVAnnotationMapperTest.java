package ua.dragunov.reflection.csvmapper;

import org.junit.Before;
import org.junit.Test;
import ua.dragunov.reflection.csvparser.CSVFileParser;
import ua.dragunov.reflection.csvparser.model.CSVTable;

import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.*;

public class CSVAnnotationMapperTest {

    private CSVAnnotationMapper mapper;
    private CSVFileParser parser;
    private Path source;
    private Reader reader;

    @Before
    public void setUp() throws Exception {
        mapper = new CSVAnnotationMapper();
        parser = new CSVFileParser();
        source = Path.of("D:/IdeaProjects/nixsolutions/reflection/src/test/resources/users.csv");
        reader = new FileReader("D:/IdeaProjects/nixsolutions/reflection/src/test/resources/users.csv");
    }

    @Test
    public void fileIsExist() {
        assertNotEquals(null, source);
        assertNotEquals(null, reader);
    }


    @Test
    public void isCorrectCSVDataFromFileWithPath() throws Exception {
        CSVTable table = parser.parse(source);
        List<User> users = mapper.map(table, User.class);

        assertEquals(3, users.size());

        User user = users.get(0);
        User user1 = users.get(1);
        User user2 = users.get(2);

        assertEquals("ihor", user.getLogin());
        assertEquals("drah1999", user.getPassword());
        assertEquals("ihor.drahunov@gmail.com", user.getEmail());
        assertEquals(21, user.getAge());
        assertEquals(User.Gender.MALE, user.getGender());

        assertEquals("legion1022", user1.getLogin());
        assertEquals("11133drr", user1.getPassword());
        assertEquals("legion20122@gmail.com", user1.getEmail());
        assertEquals(17, user1.getAge());
        assertEquals(User.Gender.FEMALE, user1.getGender());

        assertEquals("denis.tishenko", user2.getLogin());
        assertEquals("tich322311", user2.getPassword());
        assertEquals("den.tishenko.cc@gmail.com", user2.getEmail());
        assertEquals(31, user2.getAge());
        assertEquals(User.Gender.MALE, user2.getGender());

    }

    @Test
    public void isCorrectCSVDataFromFileWithReader() throws Exception {
        CSVTable table = parser.parse(reader);
        List<User> users = mapper.map(table, User.class);

        assertEquals(3, users.size());

        User user = users.get(0);
        User user1 = users.get(1);
        User user2 = users.get(2);

        assertEquals("ihor", user.getLogin());
        assertEquals("drah1999", user.getPassword());
        assertEquals("ihor.drahunov@gmail.com", user.getEmail());

        assertEquals("legion1022", user1.getLogin());
        assertEquals("11133drr", user1.getPassword());
        assertEquals("legion20122@gmail.com", user1.getEmail());

        assertEquals("denis.tishenko", user2.getLogin());
        assertEquals("tich322311", user2.getPassword());
        assertEquals("den.tishenko.cc@gmail.com", user2.getEmail());

    }
}