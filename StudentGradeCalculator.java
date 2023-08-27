import java.util.Scanner;

public class StudentGradeCalculator {
   public StudentGradeCalculator() {
   }

   public static void main(String[] var0) {
      Scanner var1 = new Scanner(System.in);
      System.out.print("Enter the number of subjects: ");
      int var2 = var1.nextInt();
      int[] var3 = new int[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         System.out.print("Enter marks obtained in subject " + (var5 + 1) + ": ");
         var3[var5] = var1.nextInt();
         var4 += var3[var5];
      }

      double var8 = (double)var4 / (double)var2;
      String var7 = calculateGrade(var8);
      System.out.println("Total Marks: " + var4);
      System.out.println("Average Percentage: " + var8 + "%");
      System.out.println("Grade: " + var7);
      var1.close();
   }

   public static String calculateGrade(double var0) {
      if (var0 >= 90.0) {
         return "A";
      } else if (var0 >= 80.0) {
         return "B";
      } else if (var0 >= 70.0) {
         return "C";
      } else {
         return var0 >= 60.0 ? "D" : "F";
      }
   }
}
