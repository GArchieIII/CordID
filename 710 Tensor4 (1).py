#!/usr/bin/env python
# coding: utf-8

# In[1]:


import tensorflow as tf
import warnings
# Suppress all warnings
warnings.filterwarnings('ignore')

model_path= 'C:\Users\Buster\Downloads\710 Tensor4 (1) (1)\710 Tensor4 (1)\_internal\tensorflow\python\saved_model'
loaded_model = tf.keras.models.load_model(model_path)  # Load the model


# In[2]:


import os
import numpy as np
from tensorflow.keras.preprocessing import image
from tensorflow.keras.applications.vgg16 import preprocess_input
import tensorflow as tf
import PIL
import pathlib

def predict_image(file_path, model, class_names):
    # Convert the file path to a Path object
    img_path = pathlib.Path(file_path)

    # Load the image using load_img from keras.preprocessing.image
    img = image.load_img(img_path, target_size=(225, 225))
    
    # Convert the image to a numpy array
    img_array = image.img_to_array(img)

    # Add a batch dimension
    img_array = np.expand_dims(img_array, axis=0)

    # Preprocess the image for the model
    img_array = preprocess_input(img_array)

    # Perform prediction
    prediction = model.predict(img_array)
    score = tf.nn.softmax(prediction[0])

    # Decode the prediction
    predicted_class = class_names[np.argmax(score)]

    return predicted_class


# In[3]:


import tkinter as tk
from tkinter import filedialog
import numpy as np
from tensorflow.keras.preprocessing import image
import tensorflow as tf
import pathlib

def predict_image(file_path, model, class_names):
    # Convert the file path to a Path object
    img_path = pathlib.Path(file_path)

    # Load the image using load_img from keras.preprocessing.image
    img = image.load_img(img_path, target_size=(225, 225))
    
    # Convert the image to a numpy array
    img_array = image.img_to_array(img)

    # Add a batch dimension
    img_array = np.expand_dims(img_array, axis=0)

    # Preprocess the image for the model
    img_array = tf.keras.applications.mobilenet.preprocess_input(img_array)

    # Perform prediction
    prediction = model.predict(img_array)

    # Decode the prediction
    predicted_class = class_names[np.argmax(prediction)]

    return predicted_class



# In[5]:


import sys
def main(file_path):
    # Load the saved model
    model_path = 'C:/Users/owner/Downloads/saved_model/model.keras'
    loaded_model = tf.keras.models.load_model(model_path)

    # Define your class names
    class_names = ['AUDIO', 'ELECTRICAL', 'ETHERNET', 'HDMI',  'USB A', 'USB C']

    # Perform prediction on the single image
    predicted_class = predict_image(file_path, loaded_model, class_names)


# Example usage:
if __name__ == "__main__":
    # Example file path obtained from Java GUI
    if len(sys.argv) != 2:
        print("Usage: python script_name.py <file_path>")
        sys.exit(1)

    file_path_from_gui = sys.argv[1]
    main(file_path_from_gui)


# In[ ]:




