require "test_helper"

class ItemMailerTest < ActionMailer::TestCase
  test "item_created" do
    mail = ItemMailer.item_created
    assert_equal "Item created", mail.subject
    assert_equal ["to@example.org"], mail.to
    assert_equal ["from@example.com"], mail.from
    assert_match "Hi", mail.body.encoded
  end

end
