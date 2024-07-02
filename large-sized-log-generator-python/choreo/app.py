from flask import Flask, request, jsonify
import logging
import random
import string

app = Flask(__name__)

logging.basicConfig(level=logging.INFO)
logger = logging.getLogger(__name__)

content = ''
with open('20MB.txt', 'r') as file:
    for chunk in iter(lambda: file.read(4096), ''):  # Read in chunks of 4096 bytes
        content += chunk

@app.route('/generate_log', methods=['POST'])
def generate_log():
    
    logger.info(f"Generated string: {content}")
    
    return jsonify({"message": f"Logged a random string"}), 201

if __name__ == '__main__':
    app.run(host='0.0.0.0', port='9090')
