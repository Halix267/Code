class FoodRatings {

    Map<String,PriorityQueue<Food>> x = new HashMap<>();
    Map<String,Food> map = new HashMap<>();
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        
        for(int i=0;i<foods.length;i++){
            
            Food cur = new Food(foods[i],cuisines[i],ratings[i]);
            
            x.putIfAbsent(cuisines[i],new PriorityQueue<>((a,b)->{
                
                return (a.rating==b.rating)?(a.name.compareTo(b.name)):(b.rating-a.rating);
            }));
            
            PriorityQueue<Food> pq = x.get(cuisines[i]);
            pq.add(cur);
            x.put(cuisines[i],pq);
            map.put(foods[i],cur);
            
        }
        
    }
    
    public void changeRating(String food, int newRating) {
        
        Food gg = map.get(food);
         PriorityQueue<Food> pq = x.get(gg.cuisine);
        pq.remove(gg);
        gg.rating = newRating;
        pq.add(gg);
        x.put(gg.cuisine,pq);
    }
    
    public String highestRated(String cuisine) {
        
        return x.get(cuisine).peek().name;
    }
}
class Food{
    int rating;
    String name;
    String cuisine;
    
    Food(String food,String cuisine,int rating){
        this.name = food;
        this.cuisine=cuisine;
        this.rating  = rating;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
