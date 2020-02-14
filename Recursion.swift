import Foundation

func evaluate(_ str: String)->Int{
    var str = str.replacingOccurrences(of: " ", with:"")

    //base case
    if str.count < 2 {
       return  Int(str) ?? 0
    }
    
    //recursive case
    var array  = Array(str)
    array.remove(at: 0)
    array.remove(at: array.count - 1)

    var i = 0;
    var count = 0;
    while(i < array.count){
        if(array[i] == "("){
            count += 1
        }else if(array[i] == ")"){
            count -= 1
        }

        if(count == 0){
            if(array[i] == "+" || array[i] == "*"){

            let left = evaluate(array[0, i])
            var calc = array[i]
            let right = evaluate(array[i + 1, array.count])
            
            if(calc == "+"){
                    return left + right
                }else if(calc == "*"){
                    return left * right  
                }
            }
        }

        i += 1
    }

    return -1
}

let test1 = "(6 * 3)"
print(evaluate(test1))
