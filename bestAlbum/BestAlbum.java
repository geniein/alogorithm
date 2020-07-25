package bestAlbum;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        answer = IntStream.range(0, genres.length)
                                .mapToObj(i -> new Music(genres[i], plays[i], i))
                                .collect(Collectors.groupingBy(Music::getGenres)).entrySet().stream()
                                .sorted((a,b)-> sum(b.getValue()) - sum(a.getValue()))
                                .flatMap(v->v.getValue().stream().sorted().limit(2)).mapToInt(x->x.id).toArray();
        for(int value : answer){
            System.out.print(value + " ");
        }

        List<Music> lsMusic = IntStream.range(0, genres.length)
                                        .mapToObj(i -> new Music(genres[i],plays[i],i))
                                        .collect(Collectors.toList());

        for(Music m : lsMusic){
            System.out.println(m.genres + " "+m.played);
        }
        return answer;
    }

    private int sum(List<Music> ls){
        int sum = 0;
        for(Music value : ls){
            sum += value.played;
        }
        return sum;
    }

    public class Music implements Comparable<Music>{
        private String genres;
        private int played;
        private int id;

        public Music(String _genres, int _played, int _id){
            this.genres = _genres;
            this.played = _played;
            this.id = _id;
        }
        @Override
        public int compareTo(Music _Music){
            if(this.played == _Music.played){
                return this.id - _Music.id;
            }
            return _Music.played - this.played;
        }

        public String getGenres(){
            return this.genres;
        }
    }

    public static void main(String[] args) {
        String[] genres ={"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        new BestAlbum().solution(genres, plays);
    }
}