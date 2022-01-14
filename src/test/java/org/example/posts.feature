@postsApi
Feature: posts Api

  Scenario Outline: GetPosts

    Given Base uri is "https://jsonplaceholder.typicode.com/"
    When  when use  "posts" api
    And   query by <id>
    Then  api response should have <userId> and <title>

    Examples:
      | id | userId | title                     |
      | 15 | 2      | "eveniet quod temporibus" |



