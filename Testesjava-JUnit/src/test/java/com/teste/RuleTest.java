package com.teste;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import static org.junit.Assert.*;


import java.io.File;
import java.io.IOException;

public class RuleTest {
    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Test
    public void aboldCreateNewFileInTemporaryFolder() throws IOException{
        File creanted = tmpFolder.newFile("file.txt");

        assertTrue(creanted.isFile());
        assertEquals(tmpFolder.getRoot(), creanted.getParentFile());
    }
}
