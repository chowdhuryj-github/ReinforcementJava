#!/usr/bin/env python
# coding: utf-8

# # <font color='#235347'> Introduction to Q-Learning </font>
# Q-learning is a type of reinforcement learning where an agent learns the best actions to take in different situations by trying things out and getting rewards or penalties. Over time, it builds a table (Q-table) that tells it the best move to make in any situation to maximize its total rewards

# ## <font color='#235347'> Initializing the Q-Table & Grid World </font> 
# We start by creating a simple 3x3 grid world. The agent will start at the top-left corner, and the goal is at the bottom-right corner. The agent can move in four directions: up, down, left and right.
# 
# The Q-table is like a agent's memory. It keeps track of how good each action is at each position in the grid. 
# - For each state (position) in the grid, the agent stores a Q-value for each possible action
# - The Q-value represents how good it is to take a certain action from a certain state
# 
# The agent can be at any 9 positions on the grid. At each position, the agent can choose from 4 actions, Up, Down, Left and Right. The Q-table will be a 3D table with the following dimensions:
# - 3 (rows) x 3 (columns) x 4 (actions) which gives us a 3x3x4 table
# 
# When we initialize a Q-table at the start, we initialize it with zeros because the agent doesn't know anything. This means that the agent thinks all actions are good.

# In[1]:


# the necessary imports
import numpy as np

# defining the size of the grid
grid_size = 3

# the reward function
def reward(state):
    if state == (2, 2):
        print("Goal Reached!")
        return 1 
    return 0


# In[2]:


# creating a 3x3x4 q-table
q_table = np.zeros((3, 3, 4))

# printing out the q-table
print(q_table)


# ## <font color='#235347'> Defining the Agent's Movements </font> 
# In this step, we define how the agent moves in a 3x3 grid based on its chosen action. The agent will be able to move up, down, left or right, but we'll also make sure it doesn't move outside the bounds of the grid. 

# In[3]:


# the movement function
def move(state, action):

    # retrieving the current position
    x, y = state

    # the actions
    if action == "up" and x > 0:
        return (x-1, y)
    if action == "down" and x < grid_size - 1:
        return (x+1, y)
    if action == "left" and y > 0:
        return (x, y-1)
    if action == "right" and y < grid_size - 1:
        return (x, y+1)

    return state


# ## <font color='#235347'> Exploration vs Exploitation </font> 
# In Q-learning, the agent needs to decide which action to take at each state. It does by balancing between two things:
# - Exploration: trying random actions to discover the environment
# - Exploitation: choosing the best known action based on the Q-values
# 
# In order to achieve this, we use a **epsilon-greedy** strategy. 
# - With probability epsilon, the agent will explore (choose a random action)
# - With probability 1 - epsilon, the agent will exploit (choose action with highest Q-values)
# 

# In[4]:


import random

# epsilon-greedy action selection function
def choose_action(state, epsilon=0.2):

    # generates a random floating point number
    # 0.2 means there is a 20% change the agent will explore
    if random.uniform(0, 1) < epsilon:
        # exploration: choose a random action
        return random.choice(['up', 'down', 'left', 'right'])
    
    else:
        # exploitation: choose the action with the q-value
        # q_table[state_x, state_y] accesses the q-values for the current state
        # np.argmax() finds the index of the action with the highest Q-value in that array
        state_x, state_y = state
        return ['up', 'down', 'left', 'right'][np.argmax(q_table[state_x, state_y])]


# ## <font color='#235347'> Updating the Q-table </font>
# Next, we work on updating the Q-table after the agent takes an action. The goal of Q-learning is for the agent to improve its decision making over time by learning from the environment. This is done by updating the Q-values in the Q-table based on the agent's experience. This is the formula we use to update the Q-values:
# 
# ### <font color='#235347'> Defining the Q-learning parameters </font>
# We now define the following Q-learning parameters:
# 1. Learning Rate: how much the agent should learn from new experiences
# 2. Discount Factor: how much the agent should care about future rewards
# 3. Reward Function: the reward the agent gets after taking an action

# In[5]:


# defining the learning rate
alpha = 0.1

# defining the discount factor
gamma = 0.9


# ### <font color='#235347'> Writing the Update Rule for Q-table </font>
# Using the parameters that have been set-up, we now implement the Q-learning update rule. This is the formula we use to update the Q-values:
# 
# $$
# Q(s_t, a_t) \leftarrow Q(s_t, a_t) + \alpha \left( r_{t+1} + \gamma \max_{a'} Q(s_{t+1}, a') - Q(s_t, a_t) \right)
# $$
# 
# Here are the following explanations behind each of the parameters:
# - $ Q(s_t, a_t) $ is the current Q-value for the state-action pair. This is in the Q-value
# - $ R(s,a) $ is the immediate reward the agent receives after taking action "a" in state "s"
# - $ \gamma \max_{a'} Q(s', a') $ is the estimated future reward, after the agent takes an action, it transitions to the next state "s' "
# - We then update the current Q-value with the new information from the formula

# In[6]:


# function to update q-value
def update_q_value(state, action, reward, next_state):
    state_x, state_y = state
    next_state_x, next_state_y = next_state

    # finding the action index
    action_index = ["up", "down", "left", "right"].index(action)

    # find the max q-value for the next state
    max_future_q = np.max(q_table[next_state_x, next_state_y])

    # applying the q-learning update rule
    current_q = q_table[state_x, state_y, action_index]
    q_table[state_x, state_y, action_index] += alpha * (reward + gamma * max_future_q - current_q)

    # debugging print statement
    print(f"Updated Q-value for state {state}, action {action}: {q_table[state_x, state_y, action_index]}")


# ## <font color='#235347'> Simulating a Episode & Updating Q-table </font>
# Finally, we will now simulate the agent starting at a random position on the grid and updating the Q-table. The goal of this is to allow the agent to learn. 

# In[7]:


# simulating an episode
def run_episode(start_state=(0,0), max_steps=10):

    # the starting state
    state = start_state

    # tracking the total reward for the episode
    total_reward = 0

    # running the episode a fixed number of steps
    for _ in range(max_steps):

        action = choose_action(state)
        next_state = move(state, action)
        reward_value = reward(next_state)
        total_reward += reward_value
        update_q_value(state, action, reward_value, next_state)
        state = next_state

        # goal checking 
        if state == (2, 2):
            print(f"Goal reached at step {_+1}!")
            break
    
    return total_reward


# In[24]:


total_reward = run_episode(start_state=(0, 0), max_steps=2000)
print(f"Total reward for this episode: {total_reward}")
print("Updated Q-table:")
print(q_table)

