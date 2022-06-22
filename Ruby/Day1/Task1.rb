# require 'date'
#First Question
# def repeat(n,str)
#     i=0
#     while i<=n 
#         puts str*i
#         i+=1
#     end

# end
# repeat(3,"shimo")

#Second Question
# def starts(str)
#     case str
#     when /^if/
#         return true
#     else
#         return false
#     end
# end
# puts starts("ifmahy")

# str="ifshimo"
# puts str.start_with?("if")

#Third Question
# def replace(str)
#     temp=str[0]
#     str[0]=str[str.length-1]
#     str[str.length-1]=temp
#     puts str
# end
# replace("Java")

#Fourth Question
# def add(str)
#     char=str[str.length-1]
#     puts char+str+char
# end
# add("Java")

#Fifth Question
# def leap(year)
#     if Date.leap?year
#         return "#{year} is leap year"
#     else 
#         return "#{year} is not leap year"
#     end
# end
# puts leap(2021)

#Sixth Question
# arr=[1,2,3]
# puts arr.rotate(1)

#Seventh Question
# def suma arr
#     sum = 0
#     arr.each_with_index do |value,i|
#         if value ==17
#             sum -= arr[i+1]
#         else
#             sum+=value
#         end
#     end
#     puts sum
# end
# suma([1,2,17,1,2])

#Bonus
def twoSum arr,target
    hash = {}
    arr.each_with_index do |value, i|
        temp = target - value
        if hash[temp]
            return [hash[temp], i]
        else
            hash[value] = i
        end
    end
end

p twoSum [2,7,11,15] ,9