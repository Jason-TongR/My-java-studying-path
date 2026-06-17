public class Potential_method {
    /*
        The potential method ia another way to do amortized ananlysis.
        The name is inspired by phsics. For example :
            To compress a spring requiress work.
            To compressed spring stores potential energy...

      
            
        The potential method :
            Let S be the set of all possible states of a data structure.

            Amortized cost using the potential method :
                Consider any function fi : X -> R(real number). call fi the potential.
                Consider a sequence of k operations :
                    S0 -> S1 -> S2 -> ... -> Sk
                       O0    O1    O2     Ok-1
                    
                    Si is the state of the data structure after the first i operations

                    Let ci be the actual cost of the operation Oi.
                    Define the amortized cost of the operation Oi as follows :
                        ci(hat) = ci + fi(Si+1) - fi(Si) (实际代价 + 势能变化量)
                        (如果对两边求和，得到 ： 总摊还代价 = 总实际代价 + 势能净增量)
    */
}
