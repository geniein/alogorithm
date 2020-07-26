package bestAlbum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class BestAlbum{

    class Music implements Comparable<Music>{
        private String genre;
        private int play;
        private int id;

        public Music(String _genre, int _play, int _id){
            this.genre =_genre;
            this.play = _play;
            this.id = _id;
        }
        
        @Override
        public int compareTo(Music _Music) {
            // TODO Auto-generated method stub
            if(this.play == _Music.play){
                return this.id - _Music.id;
            }
            return _Music.play - this.play;            
        }

        public String getGenre(){
            return this.genre;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer  ={};
        List<String> mLs = new ArrayList<>();
        String st = "";
        answer = IntStream.range(0, genres.length).mapToObj(o -> new Music(genres[o], plays[o], o))
                .collect(Collectors.groupingBy(Music::getGenre))
                .entrySet()
                .stream()
                .sorted((a,b) -> sum(b.getValue())-sum(a.getValue()))
                .flatMap(ls -> ls.getValue().stream().sorted().limit(2))
                .mapToInt(i -> i.id)
                .toArray();
        return answer;
    }

    private int sum(List<Music> ls){
        int sum = 0;
        for(Music m : ls){
            sum += m.play;
        }
        return sum;
    }
    
    public static void main(String[] args) {
         String[] genres ={"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        new BestAlbum().solution(genres, plays);
    }
}

// public class BestAlbum {
//     public int[] solution(String[] genres, int[] plays) {
//         int[] answer = {};
//         answer = IntStream.range(0, genres.length)
//                                 .mapToObj(i -> new Music(genres[i], plays[i], i))
//                                 .collect(Collectors.groupingBy(Music::getGenres)).entrySet().stream()
//                                 .sorted((a,b)-> sum(b.getValue()) - sum(a.getValue()))
//                                 .flatMap(v->v.getValue().stream().sorted().limit(2)).mapToInt(x->x.id).toArray();
//         for(int value : answer){
//          //   System.out.print(value + " ");
//         }

//         List<Music> lsMusic = IntStream.range(0, genres.length)
//                                         .mapToObj(i -> new Music(genres[i],plays[i],i))
//                                         .collect(Collectors.toList());

//         //lsMusic.stream().sorted((a,b)->b.played - a.played); 

//         lsMusic.sort((a,b)->{
//             System.out.println(a.played +"  " + b.played+ "  " +a.compareTo(b));
//             return b.played - a.played;
//         });

//         for(Music m : lsMusic){
//             System.out.println(m.genres + " "+m.played + " " + m.id);
//         }


//         Set<Entry<String, List<Music>>> sMusics = IntStream.range(0, genres.length)
//         .mapToObj(i -> new Music(genres[i],plays[i],i))
//         .collect(Collectors.groupingBy(Music::getGenres)).entrySet();

//         sMusics.forEach( key -> System.out.println(key.getKey()));

//         int[] oMusics = IntStream.range(0, genres.length)
//         .mapToObj(i -> new Music(genres[i],plays[i],i))
//         .collect(Collectors.groupingBy(Music::getGenres)).entrySet().stream().sorted((a,b) -> sum(a.getValue()) - sum(b.getValue()))
//         .flatMap(v->v.getValue().stream().sorted().limit(2))
//         .mapToInt(v-> v.id).toArray();
        

//         System.out.println(oMusics[0]);

        

//         return answer;
//     }

//     private int sum(List<Music> ls){
//         int sum = 0;
//         for(Music value : ls){
//             sum += value.played;
//         }
//         return sum;
//     }

//     public class Music implements Comparable<Music>{
//         private String genres;
//         private int played;
//         private int id;

//         public Music(String _genres, int _played, int _id){
//             this.genres = _genres;
//             this.played = _played;
//             this.id = _id;
//         }
//         @Override
//         public int compareTo(Music _Music){
//             if(this.played == _Music.played){
//                 return this.id - _Music.id;
//             }
//             return _Music.played - this.played;
//         }

//         public String getGenres(){
//             return this.genres;
//         }
//     }

//     public static void main(String[] args) {
//         String[] genres ={"classic", "pop", "classic", "classic", "pop"};
//         int[] plays = {500, 600, 150, 800, 2500};

//         new BestAlbum().solution(genres, plays);
//     }
// }