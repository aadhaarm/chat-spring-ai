# Spring AI Fintech and Music Chatbot

A chatbot application built to provide fintech advice (e.g., fraud detection) and music recommendations (e.g., tabla playlists for beginners). Developed to demonstrate Java and AI integration for a portfolio targeting roles in fintech and AI.

## Features
- **Endpoints**: `/fintech-chat` for fraud detection advice, `/music-chat` for music recommendations.
- Built with Spring Boot 3.2.5 and Spring AI 1.0.0.
- Integrates with a local GPT-2 model hosted on an Ubuntu 24.04.2 LTS machine (i3-2100, 8GB RAM, RTX 3070 GPU, 250GB HDD).
- Uses a custom `ChatModel` to call a FastAPI endpoint, avoiding OpenAI API costs.
- Optimized GPT-2 generation parameters (e.g., `max_length=100`) for complete responses.

## Setup
1. **Ubuntu System**:
   - Install Ubuntu 24.04.2 LTS, Python 3.10 in a virtual environment, and NVIDIA drivers/CUDA for RTX 3070.
   - Host GPT-2 model with FastAPI (`api_gpt2.py`).
2. **Mac Mini (Spring AI)**:
   - Run Spring Boot with `CustomRestChatModel.java` to call the FastAPI endpoint (`http://<Ubuntu_IP>:8001/generate`).
3. **Run**:
   - Start FastAPI: `uvicorn api_gpt2:app --host 0.0.0.0 --port 8001`
   - Start Spring Boot: `mvn spring-boot:run`
   - Test endpoints: `/chat`.

## Challenges Overcome
- Configured Python 3.10 on Ubuntu 24.04 with virtual environments.
- Resolved NVIDIA driver mismatches and Spring AI 1.0.0 API issues (e.g., custom `ChatModel` implementation).
- Optimized GPT-2 for complete responses.

## Future Improvements
- Host larger models (e.g., LLaMA 13B) on a more powerful system.
- Explore cloud deployment with AWS.

## Updates (May 28, 2025)
- Successfully upgraded to LLaMA 7B on my Ubuntu 24.04.2 LTS system (i3-2100, 8GB RAM, RTX 3070 GPU).
- Improved response quality for fintech (fraud detection) and music (tabla playlists) queries using LLaMA 7B (quantized, ~5-6GB VRAM with 4-bit quantization).
- Fixed generation issues by adding a system instruction, updating `max_length` to 200, and removing prompt repetition in FastAPI output.
- Changed FastAPI port to 8081 and updated Spring AI configuration with the correct IP (192.168.68.73).
- Maintained integration with Spring AI via FastAPI, achieving ~5-10 tokens/second.
