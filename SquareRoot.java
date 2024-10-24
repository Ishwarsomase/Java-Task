 class SquareRoot {
    public static void main(String[] args) 
	{
		// Check if an input number is provided
		
		//Blank Space 
        if (args.length == 0) 
        {
            System.out.println("number not provided");
            return;
        }
          
        try 
        {
            // Parse the input number from String to Double 
            double x = Double.parseDouble(args[0]);

            // Check if the number is negative
            //-9
            if (x < 0) 
            {  
            	//System.out.println(x);
                System.out.printf("%.2f Incorrect number%n", x);
                return;
            }

            // Initialize the Z for the square root
            double z = 1.0;
            int maxIterations = 25; //maximum iteration

            for (int i = 0; i < maxIterations; i++) 
            {
                double previousZ = z;
            
                System.out.println("I ---> " + i + " X -->"+x  +  " Z---> "+z  + " PreviousZ "+previousZ);
                z -= (z * z - x) / (2 * z); //z=z-(z * z - x) / (2 * z)

                 System.out.println("I1 ---> " + i + " X1 -->"+x  +  " Z1---> "+z + " PreviousZ "+previousZ) ;
                if (Math.abs(z - previousZ) <= 0.001) //1.0 //3.0
                {
                    break;
                }
            }

            // Output the result with 4 decimal points
            System.out.printf("%.2f %.4f%n", x, z);

        } 
        catch (NumberFormatException e) 
        {
            // Handle invalid number format
            System.out.printf("%.2f Incorrect number%n", Double.parseDouble(args[0]));
        }
	
	}
    
    
}
