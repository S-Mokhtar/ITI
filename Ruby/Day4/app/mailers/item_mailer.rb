class ItemMailer < ApplicationMailer

  # Subject can be set in your I18n file at config/locales/en.yml
  # with the following lookup:
  #
  #   en.item_mailer.item_created.subject
  #
  def item_created
    @greeting = "Hi"

    mail to: User.last.email, cc: User.all.pluck(:email), subject: "Item created yaaay!"
  end
end
