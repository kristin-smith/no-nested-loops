/**
 *
 * @author KristinSmith
 */

package check.stocks.one.loop;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class CheckStocksOneLoop {
    //Stock prices are presented in chronological order - don't sort
    public static int stockPrices[] = {9,11,8,5,7,10};
    
    public static void main(String[] args) {
        
        //Use a for loop to iterate through each "buying" stock price
        int months = stockPrices.length;
        int profit = 0;
         
        for (int i=0; i<months-1; i++) {
            int buyPrice = stockPrices[i]; 
            //You can only sell after you buy, so can exclude earlier options
            int sellOptions[] = Arrays.copyOfRange(stockPrices,i+1,months);
            if (i < months) {
                IntSummaryStatistics stat = Arrays.stream(sellOptions).summaryStatistics();
                int temp = stat.getMax() - buyPrice;
                if (temp>profit){
                    profit = temp;
                }
            }
        }
        System.out.println("max profit is $" + profit);
    } 
}
