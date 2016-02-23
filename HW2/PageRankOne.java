import java.util.ArrayList;    //necessary imports
import java.util.Scanner;

public class PageRank {    //class instantiation

	private static Scanner scanner;
	private static ArrayList<page> pages;
	private static int pageRankOfPage;
	private static int pageOutboundLinks;
	private static double tempPageRankOverOutboundLinksSum = 0;    //defining all variables to be used
	private static double finalPageRank = 0;
	
	public static void main(String[] args)
	{
		scanner = new Scanner(System.in);

		System.out.println("Enter a page name:");
		String pageName = scanner.next();
		
		System.out.println("How many outbound links does stackoverflow have?");
		int numOutboundLinks = scanner.nextInt();
		
		scanner = new Scanner(System.in);
		
		System.out.println("Available Pages:\nWikipedia\nFacebook\nTechCrunch\nTwitter\nBlueApron\nInstagram\nPinterest\nQuora\nGrubHub\nAirbnb\n\nWhich of the above pages link to " + pageName + "?");
		String[] connectors = scanner.nextLine().split(", ");
		
		System.out.println("What damping factor would you like to use?");
		double dampingFactor = scanner.nextDouble();
																							//prompting user for inputs, and recording them.
		ArrayList<page> allPages = makePageList();
		
		for (int j = 0; j < allPages.size(); j++)        										//using O(n^2) search for the matching values from user input.
		{
			for (int i = 0; i < connectors.length; i++)
			{
				if (connectors[i].equals(allPages.get(j).getPageName()))
				{
					pageRankOfPage = allPages.get(j).getPredeterminedPageRank();
					
					pageOutboundLinks = allPages.get(j).getOutboundLinks();
					
					tempPageRankOverOutboundLinksSum += (double) pageRankOfPage/pageOutboundLinks;
				}
				
			}
		}
		finalPageRank = Math.round(((double) (1-dampingFactor)/numOutboundLinks + dampingFactor*tempPageRankOverOutboundLinksSum)*100.0)/100.0;  //calculating final page rank 
		
		System.out.println("The PageRank of " + pageName + " is: " + finalPageRank + "!");
	}
	
	public static ArrayList<page> makePageList()
	{
		pages = new ArrayList<page>();
		
		pages.add(new page("Wikipedia", 10, 4));
		pages.add(new page("Facebook", 8, 4));
		pages.add(new page("TechCrunch", 6, 3));
		pages.add(new page("Twitter", 6, 4));						//This method makes an ArrayList that will be used in the main method
		pages.add(new page("BlueApron", 4, 1));
		pages.add(new page("Instagram", 1, 1));
		pages.add(new page("Pinterest", 7, 4));
		pages.add(new page("Quora", 5, 3));
		pages.add(new page("GrubHub", 2, 2));
		pages.add(new page("Airbnb", 4, 2));
		
		return pages;
	}
}

class page
{
	private String pageName;										//This class definition is used for the ArrayList method within the PageRank class.
	private int outboundLinks;
	private int predeterminedPageRank;
	
	public page(String pageName, int outboundLinks, int predeterminedPageRank)
	{
		this.pageName = pageName;
		this.outboundLinks = outboundLinks;
		this.predeterminedPageRank = predeterminedPageRank;
	}
	
	public String getPageName()
	{
		return pageName;
	}
	
	public int getOutboundLinks()
	{
		return outboundLinks;
	}
	
	public int getPredeterminedPageRank()
	{
		return predeterminedPageRank;
	}
}
