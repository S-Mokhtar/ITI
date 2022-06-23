module FisrtModule
require "date"
class Person
    @fname="Mahy"
    @lname="Mohsen"
    @b_date="1999-09-09"
    @age="23"

    def getData()
        puts "Enter your first name"
        @fname=gets.chomp
        puts "Enter your last name"
        @lname=gets.chomp
        puts "Enter your Birth date"
        @b_date=gets.chomp
        @b_date=Date.parse(@b_date)
        diff = Date.today - @b_date
        age = (diff / 365.25).floor
        @age = age.to_s
    end
    def print()
        puts "Welcome #@fname #@lname"
        now = Time.now.utc.to_date
        this_year_birthday = @b_date
        this_year_birthday = Date.parse("#{now.year}-#{@b_date.month}-#{@b_date.day}")
        days = (now - this_year_birthday).to_i
        if days < 0
          days += 365
        end
        months = (days/30).to_i
        puts "Your age is: #@age years, #{months} months and #{days%30} days"
    end
end    
end

person_obj=FisrtModule::Person.new()
person_obj.getData
person_obj.print