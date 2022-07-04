Rails.application.routes.draw do
  root "products#index"
  get 'admins/', to: "admins#index"
  get "admins/:id", to: "admins#show"

  # resources :admins do
  resources :products
  # end
end
