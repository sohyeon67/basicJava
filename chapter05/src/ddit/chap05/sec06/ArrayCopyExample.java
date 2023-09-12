/**
 * 배열복사 - 얕은 복사, 깊은 복사
 * 2)깊은 복사(deep copy)
 * - 배열이 별도로 생성되어 원본 배열의 값을 복사
 * - for문 이용(수동 복사), clone(), arraycopy()
 * 
 * 
 */
package ddit.chap05.sec06;

import java.util.Arrays;

public class ArrayCopyExample {

   public static void main(String[] args) {
      forCopy();
      System.out.println();
      cloneCopy();
      System.out.println();
      arrayCopy();
   }
   
   public static void forCopy() {
      
      int[] source = {10,20,30,40,50};
      int[] target = new int[source.length];
      
      for(int i=0; i<source.length;i++) {
         target[i]=source[i];
      }
      
      target[1]=9000; //for문 밖에서 선언하는 것은 영향을 미치지 않음.
      System.out.println("source : "+Arrays.toString(source));
      System.out.println("target : "+Arrays.toString(target));
      
   }
   
   public static void cloneCopy() {
      int[] source = {10,20,30,40,50};      
      int[] target = source.clone();
      //배열 타입으로 똑같이 맞춰주어야 함
      
      System.out.println("source : "+Arrays.toString(source));
      System.out.println("target : "+Arrays.toString(target));
   }
   
   public static void arrayCopy() {
      int[] source = {10,20,30,40,50};
      //System.arraycopy(src, srcPos, dest, destPos, length);
      /* 
       * src : 원본배열명
       * srcPos : 원본배열에서 복사해줄 위치
       * dest : 복사 받을 배열명
       * destPos : 복사받을 배열 위치
       * length : 복사해줄 배열 요소의 수
       * 
       */
      
      int[] target = new int[10];
      System.arraycopy(source, 0, target, 4, source.length);
      
      System.out.println("source : "+Arrays.toString(source));
      System.out.println("target : "+Arrays.toString(target));
      
   }
}