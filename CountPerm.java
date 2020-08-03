import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result{
    
    static HashMap< Character, Long > count = new HashMap<>();
    
    static long norm = ( long )( Math.pow( 10, 9 ) + 7 );
    static long init = 1;
    
    public static int countPerms( int n ){
        
        char vowels[] = { 'a', 'e', 'i', 'o', 'u' };
        long result = 0;
        
        for( int i = 0; i < vowels.length; i ++ ){
            count.put( vowels[i], init );
        }
        
        for( int i = 0; i < n - 1; i ++ ){
            
            HashMap< Character, Long > temp = new HashMap<>();
            
            temp.put( vowels[0], Math.floorMod( count.get( vowels[1] ), norm ) );
            temp.put( vowels[1], Math.floorMod( ( count.get( vowels[0] ) + count.get( vowels[2] ) ), norm ) );
            temp.put( vowels[2], Math.floorMod( ( count.get( vowels[0] ) + count.get( vowels[1] ) + count.get( vowels[3] ) + count.get( vowels[4] ) ), norm ) );
            temp.put( vowels[3], Math.floorMod( ( count.get( vowels[2] ) + count.get( vowels[4] ) ), norm ) );
            temp.put( vowels[4], Math.floorMod( count.get( vowels[0] ), norm ) );
            
            count = ( HashMap< Character, Long > )temp.clone();
            
        }
        
        for( int i = 0; i < vowels.length; i ++ ){
            result += count.get( vowels[i] );
        }
        
        result = Math.floorMod( result, norm );
        return ( int )result;
        
    }
    
}
