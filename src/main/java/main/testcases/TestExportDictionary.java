package main.testcases;

import actions.ExportDictionary;
import common.Constants;

public final class TestExportDictionary {
    private TestExportDictionary() {}

    public static void testExportDictionary() {
        String dictLanguage = Constants.FRENCH_LANGUAGE;
        System.out.println("--- ExportDictionary - Testcase (1) ---");
        ExportDictionary.exportDictionary(dictLanguage);

        dictLanguage = Constants.ROMANIAN_LANGUAGE;
        System.out.println("--- ExportDictionary - Testcase (2) ---");
        ExportDictionary.exportDictionary(dictLanguage);

        dictLanguage = Constants.SPANISH_LANGUAGE;
        System.out.println("--- ExportDictionary - Testcase (3) ---");
        ExportDictionary.exportDictionary(dictLanguage);
    }
}
