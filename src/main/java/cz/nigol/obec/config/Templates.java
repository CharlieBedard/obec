package cz.nigol.obec.config;

public class Templates {
    public static final String ANNOUNCEMENT_SUBJ =
        "Hlášení obecního rozhlasu, Obec Tršice";
    public static final String ANNOUNCEMENT =
        "<html><body><h1>Hlášení obecního rozhlasu</h1>" + 
        "<center><img style='width: 100px' src='https://www.trsice.cz/erb.png'></img></center>" +
        "<p>VARIABLE1</p><br>" +
        "<p><i>Další hlášení naleznete v <a href='https://www.trsice.cz/obecni-urad/rozhlas/hlaseni.jsf'>archivu</a>.</i></p><br><br>" +
        "<p style='font-size: small'>Tento email dostáváte, protože jste se přihlásil/a k odběru hlášení. " +
        "Pokud již nechcete tato hlášení dostávat, <a href='https://www.trsice.cz/odhlaseni.jsf?r=VARIABLE2'>klikněte pro odhlášení</a>.</p>" +
        "</body></html>";

    public static final String PASS_RESET_SUBJ = 
        "Změna hesla, Obec Tršice";
    public static final String PASS_RESET =
        "<html><body><h1>Změna hesla</h1>" + 
        "<center><img style='width: 100px' src='https://www.trsice.cz/erb.png'></img></center>" +
        "<p>Na webových stránkách <a href='https://www.trsice.cz'>Obce Tršice</a> " + 
        "jste požádal/a o změnu hesla. Nové heslo nastavíte kliknutím " + 
        "<a href='https://www.trsice.cz/zmena-hesla.jsf?t=VARIABLE1'>ZDE</a>.</p><br>" +
        "<p>Pokud Vám nefunguje odkaz, zkopírujte a vložte do prohlížeče adresu " + 
        "https://www.trsice.cz/zmena-hesla.jsf?t=VARIABLE1</p><br><br>" +
        "<p style='font-size: small'>Tento email dostáváte, protože jste se přihlásil(a) k odběru hlášení. " +
        "Pokud již nechcete tato hlášení dostávat, <a href='https://www.trsice.cz/odhlaseni.jsf?r=VARIABLE2'>klikněte pro odhlášení</a>.</p>" +
        "</body></html>";
}
