package GameDevelopment.Class;

public class wordsTitle {
    static void registerTitle(String title) {
         String blue="\u001B[96m";
         String reset="\u001B[0m";
         String red="\u001B[91m";

        System.out.println();
        System.out.println(reset);

        String[] lines = title.split("\\r?\\n");

        // Calculate the indentation required for center alignment
        int maxLineLength = 0;
        for (String line : lines) {
            maxLineLength = Math.max(maxLineLength, line.length());
        }
        int spaces = (100 - maxLineLength) / 2; // Assuming console width is 80 characters

        // Print each line centered
        for (String line : lines) {
            System.out.printf("%" + spaces + "s%s%n", "", line);

            try {
                Thread.sleep(200);
            } catch (Exception ignore) {

            }
        }
    }


    public static void moneyTitle() {
        String money = """

                 /$$      /$$                                           /$$$$$$$       /$$     /$$
                | $$$    /$$$                                          | $$__  $$     |  $$   /$$/
                | $$$$  /$$$$ /$$$$$$ /$$$$$$$  /$$$$$$ /$$   /$$      | $$  \\ $$/$$$$$\\  $$ /$$/
                | $$ $$/$$ $$/$$__  $| $$__  $$/$$__  $| $$  | $$      | $$$$$$$|____  $\\  $$$$/ 
                | $$  $$$| $| $$  \\ $| $$  \\ $| $$$$$$$| $$  | $$      | $$____/ /$$$$$$$\\  $$/  
                | $$\\  $ | $| $$  | $| $$  | $| $$_____| $$  | $$      | $$     /$$__  $$ | $$   
                | $$ \\/  | $|  $$$$$$| $$  | $|  $$$$$$|  $$$$$$$      | $$    |  $$$$$$$ | $$   
                |__/     |__/\\______/|__/  |__/\\_______/\\____  $$      |__/     \\_______/ |__/   
                                                        /$$  | $$                                
                                                       |  $$$$$$/                                
                                                        \\______/                                 
                """;
        registerTitle(money);

        String s = "By HariMani";
        int space = (160 - (s).length()) / 2;

        // Print the spaces followed by "Money:" and the money value
        System.out.printf("%" + space + "s", "");
        System.out.printf("%s", s);

    }
    static void LoginTitle(){
        String Login=("  _    ___   ___ ___ _  _ \n" +
                " | |  / _ \\ / __|_ _| \\| |\n" +
                " | |_| (_) | (_ || || .` |\n" +
                " |____\\___/ \\___|___|_|\\_|\n" +
                "                          ");

        registerTitle(Login);

    }
    static void RegisterTitle(){
        String register=("  ___ ___ ___ ___ ___ _____ ___ ___ \n" +
                " | _ \\ __/ __|_ _/ __|_   _| __| _ \\\n" +
                " |   / _| (_ || |\\__ \\ | | | _||   /\n" +
                " |_|_\\___\\___|___|___/ |_| |___|_|_\\\n" +
                "                                    ");
        registerTitle(register);
    }
    static void ProfileTitle(){
        String profile=("  ___ ___  ___  ___ ___ _    ___ \n" +
                " | _ \\ _ \\/ _ \\| __|_ _| |  | __|\n" +
                " |  _/   / (_) | _| | || |__| _| \n" +
                " |_| |_|_\\\\___/|_| |___|____|___|\n" +
                "                                 ");
        registerTitle(profile);
    }
    static void UPiTitle(){
        String upi =("  _   _ ___ ___ \n" +
                " | | | | _ \\_ _|\n" +
                " | |_| |  _/| | \n" +
                "  \\___/|_| |___|\n" +
                "                ");
        registerTitle(upi);
    }
    static void PayTitle(){
        String pay=("  ___           \n" +
                " | _ \\__ _ _  _ \n" +
                " |  _/ _` | || |\n" +
                " |_| \\__,_|\\_, |\n" +
                "           |__/ ");
        registerTitle(pay);
    }
    static void HistoryTitle(){
        String history=("  _  _ ___ ___ _____ ___  _____   __\n" +
                " | || |_ _/ __|_   _/ _ \\| _ \\ \\ / /\n" +
                " | __ || |\\__ \\ | || (_) |   /\\ V / \n" +
                " |_||_|___|___/ |_| \\___/|_|_\\ |_|  \n" +
                "                                    ");
        registerTitle(history);
    }
    static void BalanceTitle(){
        String balance=("  ___   _   _      _   _  _  ___ ___ \n" +
                " | _ ) /_\\ | |    /_\\ | \\| |/ __| __|\n" +
                " | _ \\/ _ \\| |__ / _ \\| .` | (__| _| \n" +
                " |___/_/ \\_\\____/_/ \\_\\_|\\_|\\___|___|\n" +
                "                                     ");
        registerTitle(balance);
    }
    static void PasswordTitle(){
        String password=("  ___  _   ___ _____      _____  ___ ___  \n" +
                " | _ \\/_\\ / __/ __\\ \\    / / _ \\| _ \\   \\ \n" +
                " |  _/ _ \\\\__ \\__ \\\\ \\/\\/ / (_) |   / |) |\n" +
                " |_|/_/ \\_\\___/___/ \\_/\\_/ \\___/|_|_\\___/ \n" +
                "                                          ");
        registerTitle(password);
    }

    static void SettingTitle(){
        String setting=("  ___ ___ _____ _____ ___ _  _  ___ ___ \n" +
                " / __| __|_   _|_   _|_ _| \\| |/ __/ __|\n" +
                " \\__ \\ _|  | |   | |  | || .` | (_ \\__ \\\n" +
                " |___/___| |_|   |_| |___|_|\\_|\\___|___/\n" +
                "                                        ");
        registerTitle(setting);
    }
    static void TermsConditionTitle(){
        String terms=("  _____ ___ ___ __  __ ___     __        ___ ___  _  _ ___ ___ _____ ___ ___  _  _ \n" +
                " |_   _| __| _ \\  \\/  / __|   / _|___   / __/ _ \\| \\| |   \\_ _|_   _|_ _/ _ \\| \\| |\n" +
                "   | | | _||   / |\\/| \\__ \\   > _|_ _| | (_| (_) | .` | |) | |  | |  | | (_) | .` |\n" +
                "   |_| |___|_|_\\_|  |_|___/   \\_____|   \\___\\___/|_|\\_|___/___| |_| |___\\___/|_|\\_|\n" +
                "                                                                                   ");

        registerTitle(terms);
    }static void PersonalInfoTitle(){
        String info=("  ___ ___ ___  ___  ___  _  _   _   _       ___ _  _ ___ ___  \n" +
                " | _ \\ __| _ \\/ __|/ _ \\| \\| | /_\\ | |     |_ _| \\| | __/ _ \\ \n" +
                " |  _/ _||   /\\__ \\ (_) | .` |/ _ \\| |__    | || .` | _| (_) |\n" +
                " |_| |___|_|_\\|___/\\___/|_|\\_/_/ \\_\\____|  |___|_|\\_|_| \\___/ \n" +
                "                                                              ");
        registerTitle(info);
    }static void NewAccountTitle(){
   String NewAccount=("  _  _ _____      __    _   ___ ___ ___  _   _ _  _ _____ \n" +
           " | \\| | __\\ \\    / /   /_\\ / __/ __/ _ \\| | | | \\| |_   _|\n" +
           " | .` | _| \\ \\/\\/ /   / _ \\ (_| (_| (_) | |_| | .` | | |  \n" +
           " |_|\\_|___| \\_/\\_/   /_/ \\_\\___\\___\\___/ \\___/|_|\\_| |_|  \n" +
           "                                                          ");
        registerTitle(NewAccount);
    }

}

