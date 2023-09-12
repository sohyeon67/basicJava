/**
 * �迭���� - ���� ����, ���� ����
 * 2)���� ����(deep copy)
 * - �迭�� ������ �����Ǿ� ���� �迭�� ���� ����
 * - for�� �̿�(���� ����), clone(), arraycopy()
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
      
      target[1]=9000; //for�� �ۿ��� �����ϴ� ���� ������ ��ġ�� ����.
      System.out.println("source : "+Arrays.toString(source));
      System.out.println("target : "+Arrays.toString(target));
      
   }
   
   public static void cloneCopy() {
      int[] source = {10,20,30,40,50};      
      int[] target = source.clone();
      //�迭 Ÿ������ �Ȱ��� �����־�� ��
      
      System.out.println("source : "+Arrays.toString(source));
      System.out.println("target : "+Arrays.toString(target));
   }
   
   public static void arrayCopy() {
      int[] source = {10,20,30,40,50};
      //System.arraycopy(src, srcPos, dest, destPos, length);
      /* 
       * src : �����迭��
       * srcPos : �����迭���� �������� ��ġ
       * dest : ���� ���� �迭��
       * destPos : ������� �迭 ��ġ
       * length : �������� �迭 ����� ��
       * 
       */
      
      int[] target = new int[10];
      System.arraycopy(source, 0, target, 4, source.length);
      
      System.out.println("source : "+Arrays.toString(source));
      System.out.println("target : "+Arrays.toString(target));
      
   }
}