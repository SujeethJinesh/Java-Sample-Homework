import java.util.Scanner;

public class PageRank {

    private static Scanner scanner;
    private static int pageRankOfPage;
    private static int pageOutboundLinks;
    private static double tempPageRankOverOutboundLinksSum = 0;
    private static double finalPageRank = 0;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.println("Enter a page name:");
        String pageName = scanner.next();

        System.out.println("How many outbound links does stackoverflow have?");
        int numOutboundLinks = scanner.nextInt();

        scanner = new Scanner(System.in);

        System.out.println("Available Pages:"
                + "\nWikipedia"
                + "\nFacebook"
                + "\nTechCrunch"
                + "\nTwitter"
                + "\nBlueApron"
                + "\nInstagram"
                + "\nPinterest"
                + "\nQuora"
                + "\nGrubHub"
                + "\nAirbnb"
                + "\n\nWhich of the above pages link to " + pageName + "?");
        String[] connectors = scanner.nextLine().split(", ");

        System.out.println("What damping factor would you like to use?");
        double dampingFactor = scanner.nextDouble();

        for (int i = 0; i < connectors.length; i++) {
            switch (connectors[i]) {
            case "Wikipedia":
                pageRankOfPage = 4;
                pageOutboundLinks = 10;
                tempPageRankOverOutboundLinksSum +=
                        (double) pageRankOfPage / pageOutboundLinks;
                break;
            case "Facebook":
                pageRankOfPage = 4;
                pageOutboundLinks = 8;
                tempPageRankOverOutboundLinksSum +=
                        (double) pageRankOfPage / pageOutboundLinks;
                break;
            case "TechCrunch":
                pageRankOfPage = 4;
                pageOutboundLinks = 6;
                tempPageRankOverOutboundLinksSum +=
                        (double) pageRankOfPage / pageOutboundLinks;
                break;
            case "Twitter":
                pageRankOfPage = 4;
                pageOutboundLinks = 6;
                tempPageRankOverOutboundLinksSum +=
                        (double) pageRankOfPage / pageOutboundLinks;
                break;
            case "BlueApron":
                pageRankOfPage = 1;
                pageOutboundLinks = 4;
                tempPageRankOverOutboundLinksSum +=
                        (double) pageRankOfPage / pageOutboundLinks;
                break;
            case "Instagram":
                pageRankOfPage = 1;
                pageOutboundLinks = 1;
                tempPageRankOverOutboundLinksSum +=
                        (double) pageRankOfPage / pageOutboundLinks;
                break;
            case "Pinterest":
                pageRankOfPage = 4;
                pageOutboundLinks = 7;
                tempPageRankOverOutboundLinksSum +=
                        (double) pageRankOfPage / pageOutboundLinks;
                break;
            case "Quora":
                pageRankOfPage = 3;
                pageOutboundLinks = 5;
                tempPageRankOverOutboundLinksSum +=
                        (double) pageRankOfPage / pageOutboundLinks;
                break;
            case "GrubHub":
                pageRankOfPage = 2;
                pageOutboundLinks = 2;
                tempPageRankOverOutboundLinksSum +=
                        (double) pageRankOfPage / pageOutboundLinks;
                break;
            case "Airbnb":
                pageRankOfPage = 2;
                pageOutboundLinks = 4;
                tempPageRankOverOutboundLinksSum +=
                        (double) pageRankOfPage / pageOutboundLinks;
                break;
            default:
                break;
            }
        }
        finalPageRank = Math.round(((double) (1 - dampingFactor)
                / numOutboundLinks + dampingFactor
                * tempPageRankOverOutboundLinksSum) * 100.0) / 100.0;

        System.out.println("The PageRank of "
                + pageName + " is: " + finalPageRank + "!");
    }
}
