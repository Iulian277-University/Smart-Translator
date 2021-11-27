package main.testcases;

import actions.ExportDictionary;

public final class TestExportDictionary {
    private TestExportDictionary() {}

    public static void testExportDictionary() {
        ExportDictionary.exportDictionary("ro");
    }
}
