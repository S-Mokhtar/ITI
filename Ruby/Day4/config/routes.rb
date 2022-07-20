Rails.application.routes.draw do

  mount RailsAdmin::Engine => '/admin', as: 'rails_admin'
  devise_for :users
  resources :items
  scope '/admin' do
    resources :users
  end
  resources :roles

  root to: 'items#index'

  # For details on the DSL available within this file, see https://guides.rubyonrails.org/routing.html
end
