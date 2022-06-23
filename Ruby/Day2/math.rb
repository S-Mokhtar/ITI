class Calculator
    def calc(num1,num2,op)
        if num1.is_a?(Numeric) && num2.is_a?(Numeric)
            case op
            when "+"
                return num1 + num2
            when "-"
                return num1 - num2
            when "*"
                return num1 * num2
            when "/"
                if num2==0
                    return "You can't divide by zero"
                else         
                    return num1 / num2
                end
            else 
                return "Not supported operator"
            end
        else
            raise StandardError.new"You should enter number"
        end
    end
end
operation=Calculator.new
res = operation.calc(1,2,"+")

puts res