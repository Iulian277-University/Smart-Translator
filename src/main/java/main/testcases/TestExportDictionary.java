package main.testcases;

import actions.ExportDictionary;

import java.io.IOException;

public final class TestExportDictionary {
    private TestExportDictionary() {}

    public static void testExportDictionary() throws IOException {
        ExportDictionary.exportDictionary("ro");
    }

}
