package kakao_live;
import java.util.*;

class Food implements Comparable<Food>{
    private int time;
    private boolean empty;
    public Food(int time) {
    this.time = time; 
    }
    
    public int getTime() {
    return time;
    }
    public void eat(int time) {
    this.time -= time;
    if (this.time <= 0) empty = true;
    }
    public boolean isEmpty() {
    return this.empty;
    }
    @Override
    public int compareTo(Food o) {
    return Integer.compare(this.time, o.time);
    }
    }
    
    class KakaoLive {
    private long K;
    private long sumOfFoodTime;
    private List<Food> foods = new ArrayList<>();
    private List<Food> sortedFoods = new ArrayList<>();
    
    KakaoLive (int[] foodTimes, long K) {
    this.K = K;
    for (int foodTime : foodTimes) {
    foods.add(new Food(foodTime));
    sortedFoods.add(new Food(foodTime));
    sumOfFoodTime += foodTime;
    }
    
    Collections.sort(sortedFoods);
    }
    
    public int run() {
    if (sumOfFoodTime <= K) return -1;
    
    int width = foods.size();
    int cycle = 0;
    int minIndex = 0;
    
    while (K >= width) {
    K -= width;
    cycle++;
    while( sortedFoods.get(minIndex).getTime() - cycle <= 0) {
    minIndex++;
    width--;
    }
    }
    final int totalCycle = cycle;
    foods.forEach(food-> food.eat(totalCycle));
    
    int index = 0;
    while (K-- > 0) {
    while (foods.get(index).isEmpty()) index = (index + 1) % foods.size();
    foods.get(index).eat(1);
    index = (index + 1) % foods.size();
    }
    
    while (foods.get(index).isEmpty()) index = (index + 1) % foods.size();
    
    return index + 1;
    }
    }