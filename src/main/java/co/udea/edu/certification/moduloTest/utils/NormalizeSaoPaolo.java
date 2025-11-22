package co.udea.edu.certification.moduloTest.utils;

public class NormalizeSaoPaolo {
    public static String normalizeText(String text) {
        if (text == null || text.isEmpty()) return "";

        // Solo nos preocupamos por textos que contengan "Paolo"
        if (text.contains("Paolo")) {
            // Remover cualquier carácter especial antes de "o Paolo"
            return text.replaceAll("S[^a-zA-Z]o Paolo", "Sao Paolo");
        }

        return text;
    }
}
