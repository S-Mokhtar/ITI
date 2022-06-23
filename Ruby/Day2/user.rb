class User
    @@name='user'
    def initialize(value='Shaimaa')
      @name = value
    end
    def getName
        @name
    end
    def setName=(value)
        @name=value
    end
    def self.changeName(value)
        @@name=value
    end
    def self.returnName
        return @@name
    end
end
user=User.new
user.setName=('Mahitab')
name=user.getName
puts name
puts User.returnName
puts User.changeName('Another User')
