public class EnglishWords
{
    public static void main(String[] args) {
        String text = "s Saudi Arabia is looking to open the spigots and fight for market share,\" said Matt Smith, director of commodity research at ClipperData. \"Saudi is rolling up its sleeves for a price war.\"\n" +
                "Analysts said that Russia's refusal to cut production amounted to a slap to US shale oil producers, many of which need higher oil prices to survive.\n" +
                "\"Russia has been dropping hints that the real target is the US shale oil producers, because it is fed up with cutting output and just leaving them with space,\" analysts at energy consulting firm FGE wrote in a note to clients Sunday. \"Such an attack may be doomed to failure unless prices remain low for a long time.\"\n" +
                "The 2014-2016 oil crash caused dozens of oil and gas companies to file for bankruptcy and hundreds of thousands of layoffs. However, the US shale industry emerged from that period stronger and the United States would eventually become the world's lea";
        String[] sentecces = text.split("\\s");
        for (int i = 0; i < text.split("\\s").length;i++)
        {
            System.out.println(sentecces[i]);
        }


    }
}
